package pl.mateusz.Cars.models;

public enum SegmentType {

    A("A"),
    B("B"),
    C("C"),
    D("D"),
    E("E"),
    F("F");

    private String segmentType;

    SegmentType (String segmentType){
        this.segmentType = segmentType;
    }

    public String getSegmentType() {
        return segmentType;
    }

}
