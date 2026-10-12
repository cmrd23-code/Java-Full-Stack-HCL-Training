import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

public final class Employee {
    private final UUID id;
    private final String name;
    private final BigDecimal salary;
    private final LocalDate hireDate;
    private final Set<String> skills;

    public Employee(UUID id, String name, BigDecimal salary, LocalDate hireDate, Set<String> skills) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name must not be blank");
        }
        this.name = name;

        this.salary = Objects.requireNonNull(salary, "salary must not be null");
        if (salary.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("salary must not be negative");
        }
        this.hireDate = Objects.requireNonNull(hireDate, "hireDate must not be null");

        Objects.requireNonNull(skills, "skills must not be null");
        Set<String> skillsCopy = new HashSet<>();
        for (String skill : skills) {
            skillsCopy.add(Objects.requireNonNull(skill, "skills must not contain null"));
        }
        this.skills = Collections.unmodifiableSet(skillsCopy);
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public Set<String> getSkills() {
        return skills;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Employee)) {
            return false;
        }
        Employee employee = (Employee) other;
        return id.equals(employee.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
