package com.example.transliterator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CharValidatorTest {
    /**
     * アスキー文字のみ
     */
    @Test
    public void isAsciiTest() {
        assertTrue(CharValidator.isAscii("a"));
        assertTrue(CharValidator.isAscii("A"));
        assertTrue(CharValidator.isAscii("0"));
        assertTrue(CharValidator.isAscii("!"));
        assertTrue(CharValidator.isAscii(" "));  // White space
        assertTrue(CharValidator.isAscii("azAZ09 !|[]/_"));
        assertTrue(CharValidator.isAscii(""));

        assertFalse(CharValidator.isAscii("あ"));
        assertFalse(CharValidator.isAscii("ア"));
        assertFalse(CharValidator.isAscii("ｱ"));
        assertFalse(CharValidator.isAscii("漢字"));
        assertFalse(CharValidator.isAscii("aあ"));
        assertFalse(CharValidator.isAscii("アZ"));
        assertFalse(CharValidator.isAscii("ｱ!"));
        assertFalse(CharValidator.isAscii("0漢字9"));
        assertFalse(CharValidator.isAscii("\u000F")); // SIN (Control char)
        assertFalse(CharValidator.isAscii("　"));  // Full-width White space
    }

    /**
     * 半角カナのみ
     */
    @Test
    public void isHankakuKanaTest() {
        assertTrue(CharValidator.isHankakuKana("ｱ"));
        assertTrue(CharValidator.isHankakuKana("ｦｧｨｩｪｫｬｭｮｯｰｱｲｳｴｵｶｷｸｹｺｻｼｽｾｿﾀﾁﾂﾃﾄﾅﾆﾇﾈﾉﾊﾋﾌﾍﾎﾏﾐﾑﾒﾓﾔﾕﾖﾗﾘﾙﾚﾛﾜﾝﾞﾟ"));

        assertFalse(CharValidator.isHankakuKana(""));
        assertFalse(CharValidator.isHankakuKana("a"));
        assertFalse(CharValidator.isHankakuKana("A"));
        assertFalse(CharValidator.isHankakuKana("0"));
        assertFalse(CharValidator.isHankakuKana("!"));
        assertFalse(CharValidator.isHankakuKana(" "));  // White space
        assertFalse(CharValidator.isHankakuKana("あ"));
        assertFalse(CharValidator.isHankakuKana("ア"));
        assertFalse(CharValidator.isHankakuKana("漢字"));
        assertFalse(CharValidator.isHankakuKana("aあ"));
        assertFalse(CharValidator.isHankakuKana("アZ"));
        assertFalse(CharValidator.isHankakuKana("ｱ!"));
        assertFalse(CharValidator.isHankakuKana("0漢字9"));
        assertFalse(CharValidator.isHankakuKana("\u000F")); // SIN (Control char)
        assertFalse(CharValidator.isHankakuKana("　"));  // Full-width White space
    }

    /**
     * 全角カナのみ
     */
    @Test
    public void isZenkakuKanaTest() {
        assertTrue(CharValidator.isZenkakuKana("ア"));
        assertTrue(CharValidator.isZenkakuKana("ァアィイゥウェエォオカガキギクグケゲコゴサザシジスズセゼソゾ" +
                "タダチヂッツヅテデトドナニヌネノハバパヒビピフブプヘベペホボポマミムメモャヤユユヨヨラリルレロヮワヰヱヲンヴー"));

        assertFalse(CharValidator.isZenkakuKana(""));
        assertFalse(CharValidator.isZenkakuKana("a"));
        assertFalse(CharValidator.isZenkakuKana("A"));
        assertFalse(CharValidator.isZenkakuKana("0"));
        assertFalse(CharValidator.isZenkakuKana("!"));
        assertFalse(CharValidator.isZenkakuKana(" "));  // White space
        assertFalse(CharValidator.isZenkakuKana("あ"));
        assertFalse(CharValidator.isZenkakuKana("ｱ"));
        assertFalse(CharValidator.isZenkakuKana("漢字"));
        assertFalse(CharValidator.isZenkakuKana("aあ"));
        assertFalse(CharValidator.isZenkakuKana("アZ"));
        assertFalse(CharValidator.isZenkakuKana("ｱ!"));
        assertFalse(CharValidator.isZenkakuKana("0漢字9"));
        assertFalse(CharValidator.isZenkakuKana("\u000F")); // SIN (Control char)
        assertFalse(CharValidator.isZenkakuKana("　"));  // Full-width White space
    }

    /**
     * ひらがなのみ
     */
    @Test
    public void isHiraganaTest() {
        assertTrue(CharValidator.isHiragana("あ"));
        assertTrue(CharValidator.isHiragana("ぁあぃいぅうぇえぉおかがきぎくぐけげこごさざしじすずせぜそぞ" +
                "ただちぢっつづてでとどなにぬねのはばぱひびぴふぶぷへべぺほぼぽまみむめもゃやゅゆょよらりるれろゎわゐゑをん"));

        assertFalse(CharValidator.isHiragana(""));
        assertFalse(CharValidator.isHiragana("a"));
        assertFalse(CharValidator.isHiragana("A"));
        assertFalse(CharValidator.isHiragana("0"));
        assertFalse(CharValidator.isHiragana("!"));
        assertFalse(CharValidator.isHiragana(" "));  // White space
        assertFalse(CharValidator.isHiragana("ア"));
        assertFalse(CharValidator.isHiragana("ｱ"));
        assertFalse(CharValidator.isHiragana("漢字"));
        assertFalse(CharValidator.isHiragana("aあ"));
        assertFalse(CharValidator.isHiragana("アZ"));
        assertFalse(CharValidator.isHiragana("ｱ!"));
        assertFalse(CharValidator.isHiragana("0漢字9"));
        assertFalse(CharValidator.isHiragana("\u000F")); // SIN (Control char)
        assertFalse(CharValidator.isHiragana("　"));  // Full-width White space
    }

    /**
     * 半角文字のみ
     */
    @Test
    public void isHankakuTest() {
        assertTrue(CharValidator.isHankaku(""));
        assertTrue(CharValidator.isHankaku("a"));
        assertTrue(CharValidator.isHankaku("A"));
        assertTrue(CharValidator.isHankaku("0"));
        assertTrue(CharValidator.isHankaku("!"));
        assertTrue(CharValidator.isHankaku("ｱ"));
        assertTrue(CharValidator.isHankaku("ｱ!"));
        assertTrue(CharValidator.isHankaku(" "));  // White space
        assertTrue(CharValidator.isHankaku("azAZ09ｦﾟ !|[]/_"));

        assertFalse(CharValidator.isHankaku("あ"));
        assertFalse(CharValidator.isHankaku("ア"));
        assertFalse(CharValidator.isHankaku("漢字"));
        assertFalse(CharValidator.isHankaku("aあ"));
        assertFalse(CharValidator.isHankaku("アZ"));
        assertFalse(CharValidator.isHankaku("0漢字9"));
        assertFalse(CharValidator.isHankaku("\u000F")); // SIN (Control char)
        assertFalse(CharValidator.isHankaku("　"));  // Full-width White space
    }

    /**
     * 全角文字のみ
     */
    @Test
    public void isZenkakuTest() {
        assertTrue(CharValidator.isZenkaku(""));
        assertTrue(CharValidator.isZenkaku("あ"));
        assertTrue(CharValidator.isZenkaku("ア"));
        assertTrue(CharValidator.isZenkaku("ａ"));
        assertTrue(CharValidator.isZenkaku("Ａ"));
        assertTrue(CharValidator.isZenkaku("９"));
        assertTrue(CharValidator.isZenkaku("漢字"));
        assertTrue(CharValidator.isZenkaku("　"));  // Full-width White space
        assertTrue(CharValidator.isZenkaku("あアａＡ９漢字　＿！"));

        assertFalse(CharValidator.isZenkaku("a"));
        assertFalse(CharValidator.isZenkaku("A"));
        assertFalse(CharValidator.isZenkaku("0"));
        assertFalse(CharValidator.isZenkaku("!"));
        assertFalse(CharValidator.isZenkaku("ｱ"));
        assertFalse(CharValidator.isZenkaku("ｱ!"));
        assertFalse(CharValidator.isZenkaku(" "));  // White space
        assertFalse(CharValidator.isZenkaku("azAZ09ｦﾟ !|[]/_"));
        assertFalse(CharValidator.isZenkaku("aあ"));
        assertFalse(CharValidator.isZenkaku("アZ"));
        assertFalse(CharValidator.isZenkaku("0漢字9"));
        assertFalse(CharValidator.isZenkaku("\u000F")); // SIN (Control char)
    }
}
