package org.its.smkufa.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.its.smkufa.entity.News;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Path("/news")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Api(value = "/news")
public interface NewsService {
	@GET
	@Path("/{id}")
	@ApiOperation(value = "Find News By ID", response = News.class)
	News getNewsById(@PathParam("id") @ApiParam("News Id") long id);

	@GET
	@ApiOperation(value = "Find News By Name", response = News.class)
	List<News> findNewsByName(@QueryParam("name") @DefaultValue("") String name);

	@POST
	@ApiOperation(value = "Save News", response = News.class)
	News saveNews(News news);

	@PUT
	@Path("/{id}")
	@ApiOperation(value = "Update News", response = News.class)
	News updateNews(@PathParam("id") @ApiParam("News Id") long id, News news);

	@DELETE
	@Path("/{id}")
	@ApiOperation(value = "Delete News", response = News.class)
	void deleteNews(@PathParam("id") @ApiParam("News Id") long id);
}
