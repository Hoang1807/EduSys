/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package poly.com.DAO;

/**
 *
 * @author huuho
 */
public interface EduSysDAO<Entity, DataType> {

    public void insert(Entity entity);

    public int update(Entity entity);

    public int delete(DataType id);

    public Entity selectById(DataType id);

    public java.util.List<Entity> selectAll();

    public java.util.List<Entity> selectBySQL(String sql, Object... arr);
}
