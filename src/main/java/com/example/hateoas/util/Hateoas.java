package com.example.hateoas.util;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class Hateoas {
    static final String url = "http://localhost:8080";

    // list 형태의 값을 불러올 때
    // CRUD에 primaryKey가 필요함
    public static List<CustomLink> hateoasableList(HttpServletRequest request, long primaryKey) {
        List<CustomLink> links = new ArrayList<>();
        String originalPath = request.getServletPath();
        String href = url + originalPath + "/" + primaryKey;

        links.add(getCreateLink(href));
        links.add(getReadLink(href));
        links.add(getUpdateLink(href));
        links.add(getDeleteLink(href));
        return links;
    }

    // detail 형태의 값을 불러올 때
    // 이미 주소에 id 값이 있음
   public static List<CustomLink> hateoasableOne(HttpServletRequest request) {
        List<CustomLink> links = new ArrayList<>();
        String originalPath = request.getServletPath();
        String href = url + originalPath;

        links.add(getCreateLink(href));
        links.add(getUpdateLink(href));
        links.add(getDeleteLink(href));
        return links;
    }

    private static CustomLink getCreateLink(String href) {
        CustomLink link = new CustomLink();
        int endIndex = href.lastIndexOf("/");
        href = href.substring(0, endIndex);
        link.setHref(href);
        link.setType("post");
        link.setRel("create");
        return link;
    }

    private static CustomLink getReadLink(String href) {
        CustomLink link = new CustomLink();
        link.setHref(href);
        link.setType("get");
        link.setRel("read");
        return link;
    }

    private static CustomLink getUpdateLink(String href) {
        CustomLink link = new CustomLink();
        link.setHref(href);
        link.setType("update");
        link.setRel("update");
        return link;
    }

    private static CustomLink getDeleteLink(String href) {
        CustomLink link = new CustomLink();
        link.setHref(href);
        link.setType("delete");
        link.setRel("delete");
        return link;
    }

}
