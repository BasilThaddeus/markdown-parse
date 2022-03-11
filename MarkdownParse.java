// File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import org.commonmark.node.*;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

public class MarkdownParse {
    public static ArrayList<String> getLinks(String markdown) {
        Parser parser = Parser.builder().build();
	Node node = parser.parse(markdown);
	LinkCountVisitor visitor = new LinkCountVisitor();
	node.accept(visitor);
	return visitor.list;
    }
    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String contents = Files.readString(fileName);
        ArrayList<String> links = getLinks(contents);
        System.out.println(links);
    }
}

class ListVisitor extends AbstractVisitor {
	ArrayList<String> list = new ArrayList<String>();

	@Override
	public void visit(Link link) {
		list.add(link.getDestination());

		visitChildren(link);
	}
}
