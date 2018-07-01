
package com.nap.entity.result;

import java.util.List;

public class Page<T> {

    private Integer curPage = 1;

    private Integer pageSize = 5;

    private Integer totalPage;

    private Long totalCount;

    private List<T> data;

    // 生成按钮 传入按钮的链接
    public String generateButton(String href) {

        StringBuilder sb = new StringBuilder();

        if(totalPage > 1) {

            int btnSize = 10;  

            int begin = 1;
            int end = 1;

            if(totalPage <= btnSize) {
                begin = 1;
                end = totalPage;
            } else {
                int mid = btnSize / 2;  
                if(curPage < mid) {
                    begin = 1;
                    end = btnSize;
                } else {
                    end = curPage + mid + 1;
                    if(end < totalPage)
                        begin = curPage - mid + 1;
                    else {
                        end = totalPage;
                        begin = totalPage - btnSize + 1;
                    }
                }
            }
            for(int i = begin; i <= end; i++) {
                if(curPage == i)
                    sb.append("<li><a class='btn-info pjax_a a_pjax' href='" + href + i + "'>" + i + "</a></li>");
                else
                    sb.append("<li><a class='pjax_a a_pjax' href='" + href + i + "'>" + i + "</a></li>");
            }

            // 处理首末页
            String pre = "<li><a class='pjax_a a_pjax' href='" + href + (curPage - 1 <= 0 ? 1 : curPage - 1) + "'>上一页</a></li>";
            String next = "<li><a class='pjax_a a_pjax' href='" + href + (curPage + 1 >= totalPage ? totalPage : curPage + 1) + "'>下一页</a></li>";

            if(curPage != 1)
                sb.insert(0, pre);
            if(curPage != totalPage)
                sb.append(next);
        }
        return sb.toString();
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurPage() {
        return curPage;
    }

    public void setCurPage(Integer curPage) {
        this.curPage = curPage;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

}
