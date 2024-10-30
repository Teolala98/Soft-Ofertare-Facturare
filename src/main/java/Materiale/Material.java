package Materiale;

public abstract class Material{

    protected String material;


    public Material() {
}



public String getMaterial() {
    return material;
}

public void setMaterial(String material) {
    this.material = material;
}

    public abstract String getDetalii();



public abstract double calcPret();

}
