package py.com.poraplz.cursomc.module.payment.domain;

public enum PaymentState {
    PENDIENTE(1,"Estado de pago pendiente"),
    QUITADO(2,"Estado de pago concluido"),
    CANCELADO(3,"Estado de pago cancelado");

    private int value;
    private String description;

    private PaymentState(Integer value, String desc){
        this.value = value;
        this.description = desc;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static PaymentState toEnum(Integer id){

        if(id == null)
            return null;

        for(PaymentState e: PaymentState.values()){
            if(id.equals(e.getValue())){
                return e;
            }
        }
        throw new IllegalArgumentException("invalid id");
    }

}
