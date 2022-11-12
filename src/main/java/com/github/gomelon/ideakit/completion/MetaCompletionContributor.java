package com.github.gomelon.ideakit.completion;

import com.intellij.codeInsight.completion.CompletionContributor;
import com.intellij.codeInsight.completion.CompletionType;
import com.intellij.psi.PsiComment;

import static com.intellij.patterns.PlatformPatterns.psiElement;

public class MetaCompletionContributor extends CompletionContributor {

    public MetaCompletionContributor() {
        extend(CompletionType.BASIC, psiElement(PsiComment.class),
                new MetaCompletionProvider());
    }
}
