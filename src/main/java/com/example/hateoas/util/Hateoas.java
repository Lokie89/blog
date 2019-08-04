package com.example.hateoas.util;

import com.example.hateoas.properties.DescriptionVO;
import com.example.hateoas.vo.*;

import javax.servlet.http.HttpServletRequest;

public class Hateoas {

    // list 형태의 값을 불러올 때
    // CRUD에 primaryKey가 필요함
    public static LinkObject hateoasCRUD(
            HttpServletRequest request, String[] mandatoryData, String[] optionalData, long primaryKey, boolean isList, DescriptionVO descriptionVO) {
        LinkObject link = new LinkObject();
        String originalPath = request.getServletPath();
        String href = originalPath + (isList ? "/" + primaryKey : "");
        if (descriptionVO == null) {
            link.setCreate(getCreateLink(href, mandatoryData, optionalData, null));
            link.setRead(getReadLink(href, null));
            link.setUpdate(getUpdateLink(href, mandatoryData, optionalData, null));
            link.setDelete(getDeleteLink(href, null));
        } else {
            link.setCreate(getCreateLink(href, mandatoryData, optionalData, descriptionVO.getCreate()));
            link.setRead(getReadLink(href, descriptionVO.getRead()));
            link.setUpdate(getUpdateLink(href, mandatoryData, optionalData, descriptionVO.getUpdate()));
            link.setDelete(getDeleteLink(href, descriptionVO.getDelete()));
        }
        return link;
    }


    private static CreateObject getCreateLink(String href, String[] mandatoryData, String[] optionalData, String description) {
        CreateObject createObject = new CreateObject();
        createObject.setHref(href);
        createObject.setType("post");
        createObject.setDescription(description);
        createObject.setMandatoryData(mandatoryData);
        createObject.setOptionalData(optionalData);
        return createObject;
    }

    private static ReadObject getReadLink(String href, String description) {
        ReadObject readObject = new ReadObject();
        readObject.setHref(href);
        readObject.setDescription(description);
        readObject.setType("get");
        return readObject;
    }

    private static UpdateObject getUpdateLink(String href, String[] mandatoryData, String[] optionalData, String description) {
        UpdateObject updateObject = new UpdateObject();
        updateObject.setHref(href);
        updateObject.setType("update");
        updateObject.setDescription(description);
        updateObject.setMandatoryData(mandatoryData);
        updateObject.setOptionalData(optionalData);
        return updateObject;
    }

    private static DeleteObject getDeleteLink(String href, String description) {
        DeleteObject deleteObject = new DeleteObject();
        deleteObject.setHref(href);
        deleteObject.setDescription(description);
        deleteObject.setType("delete");
        return deleteObject;
    }

}
