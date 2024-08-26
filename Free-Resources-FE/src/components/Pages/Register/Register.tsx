import React from 'react';
import  styled from 'styled-components';

export function Register(){
    return (
        <ArticleEditorStyled>
            <p>hello world!</p>
        </ArticleEditorStyled>
    );
}

const ArticleEditorStyled = styled.div`
  max-width: 1000px;
  margin: 20px auto 0px;
  width: 100%;
  background: #802424;
  padding: 15px;
  border-radius: 8px;
`;

