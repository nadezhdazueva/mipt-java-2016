package ru.mipt.java2016.homework.g595.zueva.task2.task3;

import java.nio.ByteBuffer;
public class OptStrSerializerStudentStudentKey implements OptKVStorageSerializer<String> {
    @Override
     public int SrlzSize(String value) {
               return 2 * (value.length() + 1);
            }

             @Override
     public ByteBuffer srlzToStr(String value) {
                ByteBuffer serialized = ByteBuffer.allocate(SrlzSize(value));
                for (char c : value.toCharArray()) {
                        serialized.putChar(c);
                    }
                serialized.putChar('\0');
                return serialized;
            }

             @Override
     public String desrlzFrStr(ByteBuffer input) {
                StringBuilder deserialized = new StringBuilder();
                char c = input.getChar();
                while (c != '\0') {
                        deserialized.append(c);
                        c = input.getChar();
                    }
                return deserialized.toString();
            }
}