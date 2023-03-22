package com.wicket.function.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author CHS
 * @version 1.0
 * @copyright WICKET.COM
 * @classname StreamDemo
 * @description TODO
 * @date 2023/3/20 22:03
 */
public class StreamDemo {
    static List<Author> getAuthors(){
        //数据初始化
        Author author = new Author(1L,"蒙多",33,"一个从菜刀中明悟这里的祖安人",null);
        Author author2 = new Author(2L,"亚拉索",15,"狂风也追不上他的思考速度",null);
        Author author3 = new Author(3L,"易",14,"是这个世界限制了他的思维",null);
        Author author4  = new Author(3L,"易",14,"是这个世界限制了他的思维",null);
        Author author5  = new Author(4L,"易",14,"是这个世界限制了他的思维",null);

        // 书籍列表
        List<Book> book1 = new ArrayList<>();
        List<Book> book2 = new ArrayList<>();
        List<Book> book3 = new ArrayList<>();

        book1.add(new Book(1L,"刀的两侧是光明与黑暗","哲学,爱情",88,"用一把刀划分了爱恨"));
        book1.add(new Book(2L,"一个人不能死在同一把刀下","个人成长,爱情",99,"讲述如何从失败中明悟真理"));

        book2.add(new Book(3L,"那风吹不到的地方","哲学",85,"带你用思维去领略世界的尽头"));
        book2.add(new Book(3L,"那风吹不到的地方","哲学",85,"带你用思维去领略世界的尽头"));
        book2.add(new Book(4L,"吹或不吹","爱情,个人传记",56,"一个哲学家的恋爱观注定很难把他所在的时代理解"));

        book3.add(new Book(5L,"你的剑就是我的剑","爱情",56,"无法想象一个武者能对他的伴侣这么的宽容"));
        book3.add(new Book(6L,"风与剑","个人传记",100,"两个哲学家灵魂和肉体的描绘会形成什么样的火花"));
        book3.add(new Book(6L,"风与剑","个人传记",100,"两个哲学家灵魂和肉体的描绘会形成什么样的火花"));

        author.setBooks(book1);
        author2.setBooks(book2);
        author3.setBooks(book3);
        author4.setBooks(book3);

        List<Author> authorList = new ArrayList<>(Arrays.asList(author,author2,author3,author4,author5));
        return authorList;
    }
}
