package py.com.poraplz.cursomc.module.shared.domain.exceptions;

public class BrokenDataIntegrity extends RuntimeException{

    public BrokenDataIntegrity(String msg){super(msg);}

    public BrokenDataIntegrity(String msg, Throwable cause){ super(msg, cause); }
}
