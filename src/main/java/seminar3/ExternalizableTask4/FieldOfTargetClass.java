package seminar3.ExternalizableTask4;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class FieldOfTargetClass implements Externalizable {
    private int fieldInteger;
    private String fieldString;

    public FieldOfTargetClass () {}
    public FieldOfTargetClass(int fieldInteger, String fieldString) {
        this.fieldInteger = fieldInteger;
        this.fieldString = fieldString;
    }

    @Override
    public String toString() {
        return "{FieldOfTargetClass = " +
                "fieldInteger: " + fieldInteger +  // Добавляем значение целочисленного поля в строку
                ", fieldString: " + fieldString + "}";  // Добавляем значение строкового поля в строку
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(fieldInteger);
        out.writeUTF(fieldString);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.fieldInteger = in.readInt();
        this.fieldString = in.readUTF();
    }
}
