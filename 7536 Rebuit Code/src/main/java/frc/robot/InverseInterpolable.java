package frc.robot;

public interface InverseInterpolable<T> {
  double inverseInterpolate(T upper, T query);
}
