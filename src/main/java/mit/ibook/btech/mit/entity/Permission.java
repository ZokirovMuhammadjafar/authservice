package mit.ibook.btech.mit.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
public enum Permission {

    BASIC(null,null,null,"basic");

    private final Permission parent;
    private final Application application;
    private final TypePermission typePermission;
    private final String description;

    static public Set<Permission> getTypes(TypePermission typePermission) {
        return Arrays.stream(values()).filter(t -> t.typePermission.equals(typePermission)).collect(Collectors.toSet());
    }
    static public Set<Permission> getChildren(Permission permission) {
        return Arrays.stream(values()).filter(t -> t.parent == permission).collect(Collectors.toSet());
    }

    static public Optional<Permission> findByName(String name) {
        return Arrays.stream(values()).filter(t -> t.name().equals(name)).findFirst();
    }
}
