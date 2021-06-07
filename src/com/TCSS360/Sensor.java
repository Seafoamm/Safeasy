public class Sensor {
    public enum SensorTypes {
        Motion(1),
        Temperature(2),
        Water(3),
        Smoke(4);

        private int number;

        private SensorTypes(int number) {
            this.number = number;
        }

        public int getSensorType() {
            return number;
        }
    }
    private long id;
    private String code;
    private SensorTypes sensorTypes;
    private boolean enable;

    public Sensor(final String code, final SensorTypes sensorTypes, final boolean enable) {
        this.code = code;
        this.enable = enable;
        this.sensorTypes = sensorTypes;
    }

    public long getId() {
        return id;
    }
    public void setId(final long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }
    public void setCode(final String code) {
        this.code = code;
    }

    public SensorTypes getSensorTypes() {
        return sensorTypes;
    }
    public void setSensorTypes(final SensorTypes sensorTypes) {
        this.sensorTypes = sensorTypes;
    }

    public boolean isEnable() {
        return enable;
    }
    public void setEnable(final boolean enable) {
        this.enable = enable;
    }
}
