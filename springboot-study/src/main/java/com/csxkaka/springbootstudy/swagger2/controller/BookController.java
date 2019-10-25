package com.csxkaka.springbootstudy.swagger2.controller;

import com.csxkaka.springbootstudy.swagger2.entity.Book;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.*;

/**
 * springboot 继承swagger2
 *  注解说明：
 * @Api 放在类上，描述Controller的作用，可不写
 * @ApiOperation() 放在方法或接口上，描述该方法或接口的作用
 * @ApiImplicitParam() 一个请求参数，可有多个属性
 * @ApiImplicitParams({}) 多个请求参数，传入多个@ApiImplicitParam()来指定每一个参数
 * @ApiIgnore 放在方法上，忽略该方法，不会生成该方法的api文档
 * @ApiParam 单个参数描述
 * @ApiModel 用对象来接收参数
 * @ApiProperty 用对象接收参数时，描述对象的一个字段
 * @ApiResponse HTTP响应其中1个描述
 * @ApiResponses HTTP响应整体描述
 * @ApiError 发生错误返回的信息
 */
@Api(value = "swagger2测试")
@RestController
@RequestMapping(value = "/book")
public class BookController {

    /**
     * 启动项目成功后，访问http://localhost:8082/swagger-ui.html即可看到swagger界面
     *   一开始测的几次都没有显示出来swagger页面，排查了很多原因都没有解决
     *   最后发现其他类中，有的controller层中的方法@RequestMapping没有赋值，所以就直接走了这个地方
     *   改成这样@RequestMapping("/xxx"),或@RequestMapping("/")或@RequestMapping("")都可以
     *   不可以是@RequestMapping或者@RequestMapping()
     */

    // 创建线程安全的map
    Map<Long, Book> books = Collections.synchronizedMap(new HashMap<Long, Book>());

    // 查看所有图书
    @ApiOperation(value = "获取图书列表", notes = "获取图书列表")
    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public List<Book> getBooks() {
        List<Book> book = new ArrayList<>(books.values());
        return book;
    }

    // 新增图书
    @ApiOperation(value = "创建图书", notes = "创建图书")
    @ApiImplicitParam(name = "book", value = "图书详细实体", required = true, dataType = "Book")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public String postBook(@RequestBody Book book) {
        books.put(book.getId(), book);
        return "success";
    }

    // 根据id获取图书信息
    @ApiOperation(value = "获取图书详细信息", notes = "根据id获取图书信息")
    @ApiImplicitParam(name = "id", value = "ID", required = true,
            dataType = "Long", paramType = "path") // 参数类型：路径
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Book getBook(@PathVariable("id") long id) {
        return books.get(id);
    }

    // 更新图书
    @ApiOperation(value = "更新信息", notes = "根据url的id来指定更新的图书信息")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "ID", required = true,
                dataType = "Long", paramType = "path"),
        @ApiImplicitParam(name = "book", value = "图书实体book",
                required = true, dataType = "Book")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String updateBook(@PathVariable Long id, @RequestBody Book book) {
        Book book1 = books.get(id);
        book1.setName(book.getName());
        book1.setPrice(book.getPrice());
        books.put(id, book1);
        return "success";
    }

    // 删除图书
    @ApiOperation(value = "删除图书", notes = "根据url的id来删除指定图书")
    @ApiImplicitParam(name = "id", value = "图书ID", required = true, dataType = "Long", paramType = "path")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteBook(@PathVariable Long id) {
        books.remove(id);
        return "success";
    }

    @ApiIgnore  // 忽略该方法，不会生成这个方法/接口的api文档
    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String jsonTest() {
        return "hi how are you?";
    }


}
