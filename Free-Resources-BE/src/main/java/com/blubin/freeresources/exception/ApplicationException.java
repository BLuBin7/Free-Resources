package com.blubin.freeresources.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.Optional;

@Component
public class ApplicationException {

//    private static RuntimeException throwException(ExceptionType exceptionType, String messageTemplate, String... args) {
//        if (ExceptionType.ENTITY_NOT_FOUND.equals(exceptionType)) {
//            return new EntityNotFoundException(format(messageTemplate, args));
//        } else if (ExceptionType.DUPLICATE_ENTITY.equals(exceptionType)) {
//            return new DuplicateEntityException(format(messageTemplate, args));
//        } else if (ExceptionType.ALREADY_USED_ELSEWHERE.equals(exceptionType)) {
//            return new EntityAlreadyUsedException(format(messageTemplate, args));
//        } else if (ExceptionType.NOT_MATCH.equals(exceptionType)) {
//            return new EntityNotMatchException(format(messageTemplate, args));
//        } else if (ExceptionType.DUPLICATE_LEVEL.equals(exceptionType)) {
//            return new DuplicateLevelException(format(messageTemplate, args));
//        } else if (ExceptionType.NOT_SUITABLE.equals(exceptionType)) {
//            return new NotSuitableException(format(messageTemplate, args));
//        }
//        return new RuntimeException(format(messageTemplate, args));
//    }



    public static class EntityNotFoundException extends RuntimeException {
        public EntityNotFoundException(String message) {
            super(message);
        }
    }

    public static class DuplicateEntityException extends RuntimeException {
        public DuplicateEntityException(String message) {
            super(message);
        }
    }

    public static class EntityAlreadyUsedException extends RuntimeException {
        public EntityAlreadyUsedException(String message) {
            super(message);
        }
    }

    public static class EntityNotMatchException extends RuntimeException {
        public EntityNotMatchException(String message) {
            super(message);
        }
    }


    public static class DuplicateLevelException extends RuntimeException {
        public DuplicateLevelException(String message) {
            super(message);
        }
    }

    public static class NotSuitableException extends RuntimeException {
        public NotSuitableException(String message) {
            super(message);
        }
    }
}