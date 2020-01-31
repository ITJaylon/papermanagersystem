package com.paper.mapper;

import com.paper.pojo.Writer;

public interface WriterMapper {
	
	public Writer getWriterByWriterId(String writerId);
	
	public int updateWriter(Writer writer);
	
	public int insertWriter(Writer writer);
}
