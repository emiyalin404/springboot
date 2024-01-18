package net.javaguides.Dynamic;

import java.util.List;

public class DynamicReportProperties {
    List<String> columHeaders;
    List<Integer>indexesOfColumnTypeNumber;
    List<List<String>>rows;
    List<String> summary;
    public DynamicReportProperties() {
    }

    public DynamicReportProperties(List<String> columHeaders,List<Integer> indexesOfColumnTypeNumber,List<List<String>> rows ,List<String> summary) {
        this.columHeaders=columHeaders;
        this.indexesOfColumnTypeNumber=indexesOfColumnTypeNumber;
        this.rows=rows;
        this.summary=summary;
    }
    public List<String>getColumHeaders() {
        return columHeaders;
    }

    public List<Integer> getIndexesOfColumnTypeNumber(){
        return indexesOfColumnTypeNumber;
    }
    public List<String> getSummary(){
        return summary;
    }

    public List<String> getColumnHeaders() {
        return columHeaders;
    }

    public List<List<String>> getRows() {
        return rows;
    }
}
