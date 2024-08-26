package com.blubin.freeresources.config;

import com.blubin.freeresources.repository.TokenRepository;
import com.blubin.freeresources.service.JwtService;
import com.blubin.freeresources.service.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
//    private final UserDetailsService userDetailsService;
    private final UserService userDetailsService;
    private final TokenRepository tokenRepository;
    /**
     * Phương thức doFilterInternal được ghi đè từ lớp OncePerRequestFilter, được sử dụng để thực hiện xác thực và ủy quyền người dùng bằng JWT.
     * @param request HttpServletRequest: Yêu cầu HTTP đang được xử lý.
     * @param response HttpServletResponse: Phản hồi HTTP được gửi trả về cho người dùng.
     * @param filterChain FilterChain: Chuỗi các bộ lọc, được sử dụng để chuyển tiếp yêu cầu và phản hồi.
     */
    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain
    ) throws ServletException, IOException {
        // Lấy giá trị Authorization từ tiêu đề của yêu cầu
        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        final String userEmail;

        // Kiểm tra xem tiêu đề Authorization có tồn tại và bắt đầu với "Bearer " hay không
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            // Nếu không, chuyển tiếp yêu cầu và phản hồi cho FilterChain tiếp theo
            filterChain.doFilter(request, response);
            return;
        }

        // Trích xuất JWT từ tiêu đề Authorization
        jwt = authHeader.substring(7);
        // Trích xuất email người dùng từ JWT
        userEmail = jwtService.extractUsername(jwt);

        // Kiểm tra xem người dùng đã được xác thực chưa và Token có hợp lệ không
        if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            // Nếu chưa xác thực, tiến hành xác thực
//            UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);
            UserDetails userDetails = this.userDetailsService.userDetailsService().loadUserByUsername(userEmail);

            Boolean isTokenValid = tokenRepository.findByToken(jwt)
                    .map(t -> !t.isExpired() && !t.isRevoked())
                    .orElse(false);
            if (jwtService.isTokenValid(jwt, userDetails) && isTokenValid) {
                // Nếu Token và thông tin người dùng đều hợp lệ, thiết lập đối tượng xác thực
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities()
                );
                // Thiết lập chi tiết của yêu cầu xác thực
                authToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                );
                // Đặt đối tượng xác thực vào SecurityContextHolder
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        // Chuyển tiếp yêu cầu và phản hồi cho FilterChain tiếp theo
        filterChain.doFilter(request, response);
    }

}
