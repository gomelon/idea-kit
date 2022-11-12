package com.github.gomelon.ideakit.utils;

import com.goide.GoCommentsConverter;
import com.intellij.psi.PsiComment;
import com.intellij.psi.PsiElement;

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
        if (null == comment) {
            return false;
        }
        String c = comment.trim();
        return c.startsWith("+Meta");
    }

    public static boolean maybeMetaDeclaration(String text) {
        if (null == text) {
            return false;
        }
        return text.contains("+Meta");
    }

    public static boolean maybeMeta(String text) {
        if (null == text) {
            return false;
        }
        return text.trim().startsWith("+");
    }

    public static boolean maybeMeta(PsiComment psiComment) {
        return maybeMeta(extractComment(psiComment));
    }
}
