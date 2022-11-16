package com.github.gomelon.ideakit.meta;

import com.goide.GoCommentsConverter;
import com.intellij.psi.PsiComment;
import com.intellij.psi.PsiElement;
import org.apache.commons.lang3.StringUtils;

import java.util.LinkedList;
import java.util.List;

public class CommentUtils {

    private static final GoCommentsConverter converter = new GoCommentsConverter();

    private CommentUtils() {
        //EMPTY
    }

    public static List<PsiComment> getComments(PsiElement element) {
        List<PsiComment> comments = new LinkedList<>();
        PsiElement prevSibling = element;
        for (int i = 0; i < 10000; i++) {
            prevSibling = prevSibling.getPrevSibling();
            if (prevSibling == null) {
                break;
            }
            if (prevSibling instanceof PsiComment) {
                comments.add((PsiComment) prevSibling);
            } else if (prevSibling.getText().trim().length() > 0) {
                break;
            }
        }
        return comments;
    }

    public static String extractMetaDeclaration(List<PsiComment> psiComments) {
        for (PsiComment psiComment : psiComments) {
            String comment = extractComment(psiComment);
            if (isMetaDeclaration(comment)) {
                return comment;
            }
        }
        return "";
    }

    public static String extractComment(PsiComment psiComment) {
        return converter.getValidCommentText(psiComment);
    }

    public static boolean isMetaDeclaration(String comment) {
        if (StringUtils.isBlank(comment)) {
            return false;
        }
        String c = comment.trim();
        return c.startsWith(Constants.META_DECL);
    }

    public static boolean maybeMetaDeclaration(String text) {
        if (StringUtils.isBlank(text)) {
            return false;
        }
        return text.contains(Constants.META_DECL);
    }

    public static boolean maybeMeta(String text) {
        if (StringUtils.isBlank(text)) {
            return false;
        }
        return text.trim().startsWith(Constants.META_FLAG);
    }

    public static boolean maybeMeta(PsiComment psiComment) {
        return maybeMeta(extractComment(psiComment));
    }
}
