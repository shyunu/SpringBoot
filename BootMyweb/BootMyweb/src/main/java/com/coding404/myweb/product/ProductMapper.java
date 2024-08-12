package com.coding404.myweb.product;

import com.coding404.myweb.command.ProductVO;
import com.coding404.myweb.util.Criteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

@Mapper
public interface ProductMapper {
    public int productInsert(ProductVO vo);//등록
    public ArrayList<ProductVO> getList(@Param("userId") String userId, @Param("cri") Criteria cri); //목록
    public int getTotal(@Param("userId") String userId, @Param("cri") Criteria cri);
    public ProductVO getDetail(int prodId); //상세내역
    public int productUpdate(ProductVO vo); //수정
    public void productDelete(int prodId); //삭제
}
