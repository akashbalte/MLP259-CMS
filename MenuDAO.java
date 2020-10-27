package com.hexaware.MLP259.persistence;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.List;
import com.hexaware.MLP259.model.Menu;

 

/**
 * MenuDAO class used to fetch data from data base.
 * @author hexware
 */
public interface MenuDAO {
    /**
     * @return the all the Menu record.
     */
  @SqlQuery("Select * from Menu")
    @Mapper(MenuMapper.class)
    List<Menu> show();

 

   /**
   * Find a Menu by ID.
   * @param id Menu ID.
   * @return A Menu.
   */
  @SqlQuery("Select * from mlp259.menu where food_id = :id")
  @Mapper(MenuMapper.class)
  Menu findById(@Bind("id") int foodId);

 

    /**
   * Delete a Menu by ID.
   * @param id Menu ID.
   * @return A Menu.
   */
  @SqlUpdate("delete from mlp259.menu where food_id = :fid")
  @Mapper(MenuMapper.class)
  int deleteById(@Bind("fid") int foodId);

  /**
   * create a Menu Item.
   * @param id Menu ID.
   * @param name Menu NAME.
   * @param qty Menu QUANTITY.
   * @param price Menu PRICE.
   * @return A Menu.
   */
  @SqlUpdate("insert into mlp259.menu(food_id, food_name, food_qty, food_price) values (:id, :name, :qty, :price)")
    @Mapper(MenuMapper.class)
  int createMenuItem(@Bind("id") int id, @Bind("name") String name, @Bind("qty") int qty, @Bind("price") double price);

 
  /**
   * update a Menu Item
   * @param id Menu ID.
   */
  @SqlUpdate("update Menu set food_name=:menu.foodName,food_qty=:menu.quantity,food_price=:menu.foodPrice where food_id=:menu.foodId")
   void update(@BindBean("menu") Menu menu);


   @SqlUpdate("update menu set food_qty=:foodQty where food_id=:foodId")
  void updateQty(@Bind("foodId") int foodId,@Bind("foodQty") int foodQty);
}
