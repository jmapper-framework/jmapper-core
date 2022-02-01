package com.googlecode.jmapper.bean;

public class Source {

        private String id;
        private String sourceField;
        private String other;

        public String getId() {
        return id;
    }

        public void setId(String id) {
        this.id = id;
    }

        public String getSourceField() {
        return sourceField;
    }

        public void setSourceField(String sourceField) {
        this.sourceField = sourceField;
    }

        public String getOther() {
        return other;
    }

        public void setOther(String other) {
        this.other = other;
    }

        public Source(String id, String sourceField, String other) {
    }

}
