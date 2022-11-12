package com.github.gomelon.ideakit.meta;

import com.intellij.psi.PsiNamedElement;

import java.util.List;
import java.util.Optional;

public class Declaration {

    /**
     * 注解声明所在的文件 例: /home/kimloong/demo/meta.go
     */
    private String filePath;

    /**
     * 注解的限定名 例demo.Demo
     */
    private String name;

    private PsiNamedElement psiElement;
    /**
     * 注解的成员变量 例 IntValue int32
     */
    private List<Field> fields;

    public Optional<Field> getField(String fieldName) {
        return fields.stream()
                .filter(e -> fieldName.equals(e.getName()))
                .findFirst();
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PsiNamedElement getPsiElement() {
        return psiElement;
    }

    public void setPsiElement(PsiNamedElement psiElement) {
        this.psiElement = psiElement;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    public static class Field {

        private String name;
        private PsiNamedElement psiElement;
        private DeclarationFieldType type;
        private Object defaultValue;


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public PsiNamedElement getPsiElement() {
            return psiElement;
        }

        public void setPsiElement(PsiNamedElement psiElement) {
            this.psiElement = psiElement;
        }

        public DeclarationFieldType getType() {
            return type;
        }

        public void setType(DeclarationFieldType type) {
            this.type = type;
        }

        public Object getDefaultValue() {
            return defaultValue;
        }

        public void setDefaultValue(Object defaultValue) {
            this.defaultValue = defaultValue;
        }
    }
}
