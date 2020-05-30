package org.cypherpage.spring_page.dto.exceptions;

public class DtoException extends Throwable {
    private DtoErrorCode dtoErrorCode;

    public DtoException(DtoErrorCode dtoErrorCode) {
        this.dtoErrorCode = dtoErrorCode;
    }

    public DtoErrorCode getDtoErrorCode() {
        return dtoErrorCode;
    }

}
