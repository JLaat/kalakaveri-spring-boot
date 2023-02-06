package jlaat.kalakaverispring.model;

public class FishCount {
    private String fishName;
    private Long catchCount;

    public FishCount() {
    }

    public FishCount(String fishName, Long catchCount) {
        this.fishName = fishName;
        this.catchCount = catchCount;
    }

    public String getFishName() {
        return fishName;
    }

    public void setFishName(String fishName) {
        this.fishName = fishName;
    }

    public Long getCatchCount() {
        return catchCount;
    }

    public void setCatchCount(Long catchCount) {
        this.catchCount = catchCount;
    }
}
