package LastHandle;

import WorldObjects.Movables.Movable;

import java.awt.*;

/** Describes the methods an unit that is supposed to hadle cargo is supposed to have*/
public interface IHandleLast<T extends Movable> {
    boolean load(T cargo);
    T release();
    int getCargoCount();
    void updatePosition(Point position);
}
