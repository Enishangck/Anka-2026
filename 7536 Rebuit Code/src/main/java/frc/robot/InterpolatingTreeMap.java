package frc.robot;

import java.util.Map;
import java.util.TreeMap;

public class InterpolatingTreeMap<
  K extends InverseInterpolable<K> & Comparable<K>, V extends Interpolable<V>>
  extends TreeMap<K, V> {
  private static final long serialVersionUID = 8347275262778054124L;
  final int max_;

  public InterpolatingTreeMap(int maximumSize) {
    max_ = maximumSize;
  }

  public InterpolatingTreeMap() {
    this(0);
  }

  @Override
  public V put(K key, V value) {
    if (max_ > 0 && max_ <= size()) {
      K first = firstKey();
      remove(first);
    }
    super.put(key, value);
    return value;
  }

  @Override
  public void putAll(Map<? extends K, ? extends V> map) {
    System.out.println("Unimplemented Method");
  }

  public V getInterpolated(K key) {
    V gotval = get(key);
    if (gotval == null) {
      K topBound = ceilingKey(key);
      K bottomBound = floorKey(key);

      if (topBound == null && bottomBound == null) {
        return null;
      } else if (topBound == null) {
        return get(bottomBound);
      } else if (bottomBound == null) {
        return get(topBound);
      }
      V topElem = get(topBound);
      V bottomElem = get(bottomBound);
      return bottomElem.interpolate(topElem, bottomBound.inverseInterpolate(topBound, key));
    } else {
      return gotval;
    }
  }
}
