package com.github.gomelon.ideakit.meta;

import java.math.BigDecimal;

public enum DeclarationFieldType {
    INT8("int8", false) {
        @Override
        public void checkValue(Object value) {
            checkNumberValue(value, BigDecimal.valueOf(Byte.MIN_VALUE),
                    BigDecimal.valueOf(Byte.MAX_VALUE), true);
        }
    },
    UINT8("uint8", true) {
        @Override
        public void checkValue(Object value) {
            checkNumberValue(value, BigDecimal.ZERO,
                    BigDecimal.valueOf(Byte.MAX_VALUE).multiply(BigDecimal.valueOf(2)), true);
        }
    },
    INT16("int16", false) {
        @Override
        public void checkValue(Object value) {
            checkNumberValue(value, BigDecimal.valueOf(Short.MIN_VALUE),
                    BigDecimal.valueOf(Short.MAX_VALUE), true);
        }
    },
    UINT16("uint16", true) {
        @Override
        public void checkValue(Object value) {
            checkNumberValue(value, BigDecimal.ZERO,
                    BigDecimal.valueOf(Short.MAX_VALUE).multiply(BigDecimal.valueOf(2)), true);
        }
    },
    INT32("int32", false) {
        @Override
        public void checkValue(Object value) {
            checkNumberValue(value, BigDecimal.valueOf(Integer.MIN_VALUE),
                    BigDecimal.valueOf(Integer.MAX_VALUE), true);
        }
    },
    UINT32("uint32", true) {
        @Override
        public void checkValue(Object value) {
            checkNumberValue(value, BigDecimal.ZERO,
                    BigDecimal.valueOf(Integer.MAX_VALUE).multiply(BigDecimal.valueOf(2)), true);
        }
    },
    INT("int", false) {
        @Override
        public void checkValue(Object value) {
            checkNumberValue(value, BigDecimal.valueOf(Integer.MIN_VALUE),
                    BigDecimal.valueOf(Integer.MAX_VALUE), true);
        }
    },
    INT64("int64", false) {
        @Override
        public void checkValue(Object value) {
            checkNumberValue(value, BigDecimal.valueOf(Long.MIN_VALUE),
                    BigDecimal.valueOf(Long.MAX_VALUE), true);
        }
    },
    UINT64("uint64", true) {
        @Override
        public void checkValue(Object value) {
            checkNumberValue(value, BigDecimal.ZERO,
                    BigDecimal.valueOf(Long.MAX_VALUE).multiply(BigDecimal.valueOf(2)), true);
        }
    },
    FLOAT32("float32", false) {
        @Override
        public void checkValue(Object value) {
            checkNumberValue(value, BigDecimal.valueOf(Integer.MIN_VALUE),
                    BigDecimal.valueOf(Integer.MAX_VALUE), false);
        }
    },
    FLOAT64("float64", true) {
        @Override
        public void checkValue(Object value) {
            checkNumberValue(value, BigDecimal.valueOf(Long.MIN_VALUE),
                    BigDecimal.valueOf(Long.MAX_VALUE), false);
        }
    },
    STRING("string", false) {
        @Override
        public void checkValue(Object value) {
            if (value instanceof String) {
                return;
            }
            throw new BadFieldValueException("Expected a string value but not");
        }
    },
    BOOL("bool", false) {
        @Override
        public void checkValue(Object value) {
            if (value instanceof Boolean) {
                return;
            }
            throw new BadFieldValueException("Expected a bool value but not");
        }
    },
    ;

    public static DeclarationFieldType from(String goType) {
        for (DeclarationFieldType fieldType : DeclarationFieldType.values()) {
            if (fieldType.goType.equals(goType)) {
                return fieldType;
            }
        }
        return null;
    }

    private final String goType;

    private final boolean unsigned;

    DeclarationFieldType(String goType, boolean unsigned) {
        this.goType = goType;
        this.unsigned = unsigned;
    }

    public String getGoType() {
        return goType;
    }

    public boolean isUnsigned() {
        return unsigned;
    }

    public void checkValue(Object value) {

    }

    void checkNumberValue(Object value, BigDecimal min, BigDecimal max, boolean isInteger) {
        try {
            BigDecimal numberValue = new BigDecimal(value.toString());
            if (isInteger && numberValue.scale() > 0) {
                throw new BadFieldValueException(String.format("Expected a %s but not", goType));
            }
            if (numberValue.compareTo(min) < 0 || numberValue.compareTo(max) > 0) {
                throw new BadFieldValueException(String.format("out of %s value range", goType));
            }
        } catch (NumberFormatException e) {
            throw new BadFieldValueException(String.format("Expected a %s but not", goType));
        }
    }
}
