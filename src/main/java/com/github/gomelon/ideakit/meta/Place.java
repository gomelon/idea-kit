package com.github.gomelon.ideakit.meta;

public enum Place {
    CONST("Const"),
    VAR("Var"),
    INTERFACE("Interface"),
    STRUCT("Struct"),
    FIELD("Field"),
    Method("Method"),
    FUNC("Func"),
    PARAMETER("Parameter"),
    Result("Result"),
    INTERFACE_METHOD("InterfaceMethod"),
    STRUCT_METHOD("StructMethod"),
    ;

    private final String name;

    Place(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
