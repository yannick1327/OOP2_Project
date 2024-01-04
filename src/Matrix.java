import java.util.List;

public class Matrix
{
    private final int _dimensionX;
    private final int _dimensionY;

    private List<Vector> parts; // vertical separated

    public Matrix(int dimensionX,int dimensionY, Vector firstColumn,Vector secondColumn)
    {
        _dimensionX = dimensionX;
        _dimensionY = dimensionY;

        parts.add(firstColumn);
        parts.add(secondColumn);
    }

    public Matrix(int dimensionX,int dimensionY, Vector firstColumn,Vector secondColumn,Vector thirdColumn)
    {
        _dimensionX = dimensionX;
        _dimensionY = dimensionY;

        parts.add(firstColumn);
        parts.add(secondColumn);
        parts.add(thirdColumn);
    }

    public int get_dimensionX()
    {
        return _dimensionX;
    }

    public int get_dimensionY()
    {
        return _dimensionY;
    }
}
