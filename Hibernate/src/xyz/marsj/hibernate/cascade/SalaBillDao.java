package xyz.marsj.hibernate.cascade;

public interface SalaBillDao {
void save(SalaBill bill);
void update(SalaBill bill);
void delete(Long id);
SalaBill get(Long id);
}
