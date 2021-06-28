package com.victorasj.dxcprueba

import com.victorasj.domain.Photo
import com.victorasj.dxcprueba.server.PhotoInfo
import com.victorasj.dxcprueba.server.PhotoList


fun PhotoInfo.toPhoto() : Photo =
    Photo(
        id,
        photoOwner.realname,
        photoTitle.title,
        photoDate.taken,
        photoDescription.description,
        "https://live.staticflickr.com/$server/${id}_${secret}_s.jpg"
    )