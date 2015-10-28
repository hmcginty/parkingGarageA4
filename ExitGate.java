package cs414.a4.hmcginty;

public class ExitGate implements Gate{

	private GateStatus status;
	
	public ExitGate(){
		this.status = GateStatus.CLOSED;
	}
	
	@Override
	public void openGate() {
		if(this.isOpen() == false){
			this.status = GateStatus.OPEN;
		}
	}

	@Override
	public void closeGate() {
		if(this.isOpen()){
			this.status = GateStatus.CLOSED;
		}
	}

	@Override
	public boolean isOpen() {
		if(this.status.equals(GateStatus.OPEN)){
			return true;
		}else{
			return false;
		}
	}

}
