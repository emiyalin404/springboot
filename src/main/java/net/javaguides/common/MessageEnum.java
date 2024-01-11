package net.javaguides.common;

public enum MessageEnum {
    SUCCESS("success"),
    ERROR("error"),

    LOGIN_SUCCESS("登入成功"),
    QUERY_SUCCESS("查詢成功"),
    INSERT_SUCCESS("新增成功"),
    UPDATE_SUCCESS("修改成功"),
    DELETE_SUCCESS("刪除成功"),
    IMPORT_SUCCESS("匯入成功"),
    EXPORT_SUCCESS("匯出成功"),
    VERIFY_SUCCESS("驗證成功"),

    LOGIN_FAILURE("登入失敗"),
    QUERY_FAILURE("查詢失敗"),
    INSERT_FAILURE("新增失敗"),
    UPDATE_FAILURE("修改失敗"),
    DELETE_FAILURE("刪除失敗"),
    IMPORT_FAILURE("匯入失敗"),
    EXPORT_FAILURE("匯出失敗"),
    VERIFY_FAILURE("驗證失敗");

    /** 訊息 */
    final String msg;

    private MessageEnum(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
