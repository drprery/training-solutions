package exam02.cv;

import java.util.ArrayList;
import java.util.List;

class Cv {
    private String name;
    private List<Skill> skills = new ArrayList<>();

    Cv(String name) {
        this.name = name;
    }

    public void addSkills(String... sk) {
        for (String skill : sk) {
            int index = skill.indexOf("(");
            skills.add(new Skill(skill.substring(0, index-1), Integer.parseInt(skill.substring(index + 1, index + 2))));
        }
    }

    public int findSkillLevelByName(String name) {
        boolean found=false;

        for (Skill skill : skills) {
            if (skill.getName().equals(name)) {
                found=true;
                return skill.getLevel();
            }
        }
        if (!found) {
            throw new SkillNotFoundException();
        }
        return 0;
    }

    public String getName() {
        return name;
    }

    public List<Skill> getSkills() {
        return skills;
    }
}