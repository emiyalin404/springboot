package net.javaguides.enumeration;

public enum ExportType {
    PDF("pdf","application/pdf");

    private final  String extension;
    private final String contentType;

    ExportType(String extension,String contentType) {
        this.extension=extension;
        this.contentType=contentType;
    }

    public String getExtension() {
        return "." + extension;
    }

    public String getContentType() {
        return contentType;
    }
}
