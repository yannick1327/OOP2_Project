import java.util.List;

public class Vector
{
    private final int _dimension;
    private final int _firstElement;

    private final int _secondElement;

    private final int _thirdElement;

    private String _matrixColumn = "";

    public Vector(int dimension, int firstElement, int secondElement)
    {
        _dimension = dimension;
        _firstElement = firstElement;
        _secondElement = secondElement;
        _thirdElement = 0;
    }

    public Vector(int dimension, int firstElement, int secondElement, int thirdElement)
    {
        _dimension = dimension;
        _firstElement = firstElement;
        _secondElement = secondElement;
        _thirdElement = thirdElement;
    }
    public Vector(int dimension, int firstElement, int secondElement, String matrixColumn)
    {
        _dimension = dimension;
        _firstElement = firstElement;
        _secondElement = secondElement;
        _thirdElement = 0;
        _matrixColumn = matrixColumn;
    }

    public Vector(int dimension, int firstElement, int secondElement, int thirdElement, String matrixColumn)
    {
        _dimension = dimension;
        _firstElement = firstElement;
        _secondElement = secondElement;
        _thirdElement = thirdElement;
        _matrixColumn = matrixColumn;
    }

    public int get_secondElement() {
        return _secondElement;
    }

    public int get_firstElement() {
        return _firstElement;
    }

    public int get_thirdElement() {
        return _thirdElement;
    }
}
