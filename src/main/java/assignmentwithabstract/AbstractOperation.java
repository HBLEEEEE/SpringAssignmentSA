package assignmentwithabstract;

public interface AbstractOperation {
    public abstract void Start();
    public abstract void Stop();
    public abstract void GasControl(int fluctuation);
    public abstract void SpeedChange(int fluctuation);
    public abstract void PeopleUp(int crowd);
    public abstract void PeopleDown(int crowd);
    public abstract void CheckGas();
}
