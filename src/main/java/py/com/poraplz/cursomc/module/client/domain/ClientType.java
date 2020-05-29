package py.com.poraplz.cursomc.module.client.domain;


public enum ClientType {
    PERSONA_FISICA(1,"Persona Fisica"),
    PERSONA_JURIDICA(2, "Persona Juridica");

    private int cod;
    private String descripcion;

    private ClientType(int cod, String descripcion){
        this.cod = cod;
        this.descripcion = descripcion;
    }

    public static ClientType toEnum(Integer cod){
        if(cod == null){
            return null;
        }
        for (ClientType clientType : ClientType.values()){
            if (cod.equals(clientType.getCod())){
                return clientType;
            }
        }
        throw new IllegalArgumentException("id invalido: "+ cod);
    }


    public int getCod() {
        return cod;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
