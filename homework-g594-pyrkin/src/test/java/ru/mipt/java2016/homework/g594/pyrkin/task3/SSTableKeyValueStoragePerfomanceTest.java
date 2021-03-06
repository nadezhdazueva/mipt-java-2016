package ru.mipt.java2016.homework.g594.pyrkin.task3;

import org.junit.Ignore;
import org.junit.Test;
import ru.mipt.java2016.homework.base.task2.KeyValueStorage;
import ru.mipt.java2016.homework.base.task2.MalformedDataException;
import ru.mipt.java2016.homework.g594.pyrkin.task2.serializer.*;
import ru.mipt.java2016.homework.tests.task2.Student;
import ru.mipt.java2016.homework.tests.task2.StudentKey;
import ru.mipt.java2016.homework.tests.task3.KeyValueStoragePerformanceTest;

import java.io.IOException;

/**
 * Created by randan on 11/16/16.
 */
public class SSTableKeyValueStoragePerfomanceTest extends KeyValueStoragePerformanceTest {
    @Override
    protected KeyValueStorage<String, String> buildStringsStorage(String path) throws MalformedDataException {
        try {
            return new SSTableKeyValueStorage<>(path,
                    new FastStringSerializer(), new FastStringSerializer());
        }catch (IOException e){
            return null;
        }
    }

    @Override
    protected KeyValueStorage<Integer, Double> buildNumbersStorage(String path) throws MalformedDataException {
        try {
            return new SSTableKeyValueStorage<>(path, new IntegerSerializer(),
                    new DoubleSerializer());
        }catch (IOException e){
            return null;
        }
    }

    @Override
    protected KeyValueStorage<StudentKey, Student> buildPojoStorage(String path) throws MalformedDataException {
        try {
            return new SSTableKeyValueStorage<>(path, new StudentKeySerializer(),
                    new StudentSerializer());
        }catch (IOException e){
            return null;
        }
    }
}
