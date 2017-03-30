package io.as.mongodb.jackson.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Value;
import org.springframework.data.annotation.Id;

@Value /* to generate equals, hashCode, getters & toString ( immutable ) */
@NoArgsConstructor(force = true, access = AccessLevel.PACKAGE) /* just for dehydration! as default ctor is used to create object & then fields are set using refection! */
public class ToDo
{
    @Id
    private final String id;
    private final String value;
    private final boolean status;

    @lombok.Builder(builderClassName = "Builder", builderMethodName = "newBuilder", toBuilder = true)
    private ToDo(String id, @NonNull String value, boolean status)
    {
        this.id = id;
        this.value = value;
        this.status = status;
    }
}
