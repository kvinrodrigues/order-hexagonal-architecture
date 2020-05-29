package py.com.poraplz.cursomc.module.profile.domain;

public enum Profile {

    ADMIN(1,"ROLE_ADMIN"),
    CLIENT(2,"ROLE_CLIENT"),
    FORGOT(3, "ROLE_FORGOT");

    private int cod;
    private String description;

    Profile(int cod, String description) {
        this.cod = cod;
        this.description = description;
    }

    public int getCod() {
        return cod;
    }

    public String getDescription() {
        return description;
    }

    public static Profile toEnum(Integer value){
        if(value==null)
            return null;
        for(Profile profile : Profile.values()){
            if(value.equals(profile.getCod()))
                return profile;
        }
        throw new IllegalArgumentException("invalid id");
    }
}
