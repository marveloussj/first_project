package com.msj.cascace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 城市对象
 */
public class City {
	private Long id;
	private String name;

	public City() {
	}

	public City(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	/**
	 * 根据省份id查询省份中的城市!
	 * @return
	 */
	public static List<City> getCityByProvinceId(Long pid) {
		
		List<City> citys = new ArrayList<City>();
		
		if (pid == 1) {
			citys = Arrays.asList(
					new City(11L,"成都"),
					new City(12L,"南充"),
					new City(13L,"绵阳"),
					new City(14L,"遂宁"),
					new City(15L,"达州"),
					new City(16L,"宜宾"),
					new City(17L,"泸州"),
					new City(18L,"乐山")
			);
		} else if (pid == 2) {
			citys = Arrays.asList(
					new City(21L,"广州"),
					new City(22L,"深圳"),
					new City(23L,"佛山"),
					new City(24L,"中山"),
					new City(25L,"珠海"),
					new City(26L,"汕头"),
					new City(27L,"潮州"),
					new City(28L,"东莞")
			);
		} else if (pid == 3) {
			citys = Arrays.asList(
					new City(31L,"西安"),
					new City(32L,"宝鸡"),
					new City(33L,"咸阳"),
					new City(34L,"延安"),
					new City(35L,"汉中"),
					new City(36L,"渭南"),
					new City(37L,"榆林"),
					new City(38L,"咸阳")
			);
		}
		return citys;
	}
	
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return "City [id=" + id + ", name=" + name + "]";
	}
}
