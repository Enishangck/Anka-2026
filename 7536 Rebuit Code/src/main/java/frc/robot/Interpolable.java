package frc.robot;

public interface Interpolable<T> {
  T interpolate(T other, double x);
}
