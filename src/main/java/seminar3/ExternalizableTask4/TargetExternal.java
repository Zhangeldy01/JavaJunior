package seminar3.ExternalizableTask4;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class TargetExternal implements Externalizable {
    private int integerField;
    private String stringField;
    private FieldOfTargetClass field;
    private transient int transientField;

    public TargetExternal () {
    }

    public TargetExternal (int integerField, String stringField, FieldOfTargetClass field, int transientField) {
        this.integerField = integerField;
        this.stringField = stringField;
        this.field = field;
        this.transientField = transientField;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(integerField);
        out.writeUTF(stringField);
        out.writeObject(field);
        out.writeInt(transientField);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.integerField = in.readInt();
        this.stringField = in.readUTF();
        this.field = (FieldOfTargetClass) in.readObject();
        this.transientField = in.readInt();
    }

    @Override
    public  String toString () {
        return "{TargetExternal =" +
                "integerField: " + integerField +
                ", stringField: '" + stringField + '\'' +
                ", customObjectField: " + field.toString() +
                ", transientField: " + transientField + "}";
    }
}
