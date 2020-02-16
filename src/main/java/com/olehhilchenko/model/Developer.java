package main.java.com.olehhilchenko.model;

import java.util.HashSet;
import java.util.Set;

public class Developer {
    private long id;
    private String name;
    private Account account;
    private Set<Skill> skills = new HashSet<Skill>();

    public Developer() {
    }

    public Developer(long id, String name, Account account, Set<Skill> skills) {
        this.id = id;
        this.name = name;
        this.account = account;
        this.skills = skills;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setId(String id) {
        this.id = Long.parseLong(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }

    public void addSkill(Skill skill) {
        this.skills.add(skill);
    }

    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", account=" + account +
                ", skills=" + skills +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Developer developer = (Developer) o;

        if (id != developer.id) return false;
        if (name != null ? !name.equals(developer.name) : developer.name != null) return false;
        if (account != null ? !account.equals(developer.account) : developer.account != null) return false;
        return skills != null ? skills.equals(developer.skills) : developer.skills == null;
    }

    public boolean equalsById(Object o) {
        return this.id == ((Developer) o).id;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (account != null ? account.hashCode() : 0);
        result = 31 * result + (skills != null ? skills.hashCode() : 0);
        return result;
    }
}
