\ProvidesClass{report}

\LoadClass[12pt,a4paper]{article}

% packages that are regularly used
\usepackage{amsmath}
\usepackage[hidelinks]{hyperref}
\usepackage[usenames,dvipsnames]{xcolor}
\usepackage{ulem}
\usepackage{tikz}
\usepackage[utf8]{inputenc}
\usepackage{amssymb}
\usepackage{listings}
\usepackage{float}
\usepackage[english]{babel}
%\usepackage{physics}
\usepackage{fixltx2e}
\usepackage{enumerate}
\usepackage{lastpage}
\usepackage{truncate}
\usepackage[a4paper, top=3cm, bottom=3cm, left=2cm, right=2cm]{geometry}
\usepackage{pdfpages}
\usepackage{pgfplots}
\pgfplotsset{width=10cm,compat=1.9} 

\normalem

\definecolor{c991a14}{RGB}{153,26,20}
\definecolor{c999999}{RGB}{153,153,153}

\newcommand{\course}[1]{\def \course {#1}}
\newcommand{\titlepagepicture}[1]{\def \titlepagepicture {#1}}

% fields that user can set (in addition to title, author, etc)
\makeatletter
\newcommand{\candidatenum}[1]{\def \@candidatenum {#1}}
\newcommand{\subtitle}[1]{\def \@subtitle {#1}}
\newcommand{\subject}[1]{\def \@subject {#1}}
\newcommand{\wordcount}[1]{\def \@wordcount {#1}}
\newcommand{\email}[1]{\def \@email {#1}}
\candidatenum{}
\subtitle{}
\subject{}
\wordcount{}
\email{}

\newenvironment{subeq}{
  \subequations
    \align
}{
    \endalign
  \endsubequations
}

% Headers and footers
\usepackage{fancyhdr}
\pagestyle{fancy}
\lhead{\course}
\makeatletter
\rhead{\@author}
%\chead{\truncate{180pt}{\@date}}
\chead{\@date}
\cfoot{}
\rfoot{\thepage}
%\rfoot{Side \thepage\ of \pageref{LastPage}}


\definecolor{lightlightgray}{gray}{0.95} % background
\definecolor{shred}{rgb}{0.6,0,0} % for strings
\definecolor{shgreen}{rgb}{153, 153, 136} % comments
\definecolor{shpurple}{rgb}{0.5,0,0.35} % keywords

\definecolor{mygreen}{RGB}{28,172,0} % color values Red, Green, Blue
\definecolor{dkgreen}{rgb}{0,0.6,0}
\definecolor{gray}{rgb}{0.5,0.5,0.5}
\definecolor{mauve}{rgb}{0.58,0,0.82}
\definecolor{mylilas}{RGB}{170,55,241}
\lstset{language=Java,
  inputencoding=latin1,
  aboveskip=3mm,
  belowskip=3mm,
  showstringspaces=false,
  columns=flexible,
  basicstyle={\footnotesize\ttfamily},
  numbers=none,
  numberstyle=\tiny\color{gray},
  keywordstyle=\color{blue},
  commentstyle=\color{dkgreen},
  stringstyle=\color{mauve},
  breaklines=true,
  breakatwhitespace=true
  tabsize=3
}

\lstset{language=Matlab,%
    inputencoding=latin1,
    %basicstyle=\color{red},
    breaklines=true,%
    morekeywords={matlab2tikz},
    keywordstyle=\color{blue},%
    morekeywords=[2]{1}, keywordstyle=[2]{\color{black}},
    identifierstyle=\color{black},%
    stringstyle=\color{mylilas},
    commentstyle=\color{mygreen},%
    showstringspaces=false,%without this there will be a symbol in the places where there is a space
    numbers=left,%
    numberstyle={\tiny \color{black}},% size of the numbers
    numbersep=9pt, % this defines how far the numbers are from the text
    emph=[1]{for,end,break},emphstyle=[1]\color{red}, %some words to emphasise
    %emph=[2]{word1,word2}, emphstyle=[2]{style},    
}

\lstset{language=C++,
				emph={%  
				    cyg\_mutex\_lock, cyg\_cond\_timed\_wait, cyg\_mutex\_unlock%
				    },emphstyle={\color{mauve}},
                keywordstyle=\color{blue},
                stringstyle=\color{red},
                commentstyle=\color{dkgreen},
                morecomment=[l][\color{magenta}]{\#}
}

\makeatother
\makeatletter
\renewcommand{\maketitle}{
  \begin{titlepage}
    \begin{center}
      \vspace*{0.5cm}
      \begin{tikzpicture}[y=0.80pt, x=0.8pt,yscale=-1, scale=0.5, inner sep=0pt, outer sep=0pt]
        \begin{scope}[shift={(0,147.63782)}]
          \path[fill=c991a14] (1048.0000,405.3696) .. controls (1048.0000,405.3696) and
          (1071.0924,393.0689) .. (1084.0000,386.3622) .. controls (1120.0000,402.3622)
          and (1140.0000,402.3696) .. (1176.0000,386.3692) -- (1212.0000,405.3692) --
          (1176.0000,424.3617) .. controls (1140.0000,408.3617) and (1120.0000,408.3692)
          .. (1084.0540,424.3617) -- cycle;
          \path[fill=c999999] (1160.1406,353.3139) .. controls (1157.8085,349.5147) and
          (1157.9229,341.3857) .. (1157.9229,341.3857) -- (1157.9609,276.4391) --
          (1164.9609,276.4391) -- (1171.9609,276.4391) -- (1171.9859,343.1704) ..
          controls (1171.9419,349.4460) and (1174.9506,353.4771) .. (1180.5101,353.3793)
          .. controls (1186.0695,353.2815) and (1188.9912,349.4034) ..
          (1188.9912,343.1720) -- (1189.0012,276.3622) -- (1203.0012,276.3622) --
          (1202.8907,341.1264) .. controls (1202.8907,341.1264) and (1203.5281,348.6496)
          .. (1200.8017,352.9391) .. controls (1193.9764,364.3049) and
          (1180.9875,363.4287) .. (1180.9875,363.4287) .. controls (1180.9875,363.4287)
          and (1167.2514,364.8963) .. (1160.1418,353.3139) -- cycle;
          \path[fill=c999999] (1079.0000,276.5809) .. controls (1077.0720,276.5654) and
          (1075.0465,276.5997) .. (1072.9687,276.6434) -- (1058.4687,276.9247) --
          (1058.1875,318.4247) .. controls (1058.0438,341.2493) and (1058.0000,361.3622)
          .. (1058.4375,361.2684) .. controls (1058.8442,362.3282) and
          (1062.3813,362.5348) .. (1075.4062,362.2684) .. controls (1090.1344,361.9672)
          and (1092.1204,361.7107) .. (1094.5937,359.8622) .. controls
          (1098.5809,356.8825) and (1100.9620,353.3376) .. (1102.0000,348.8622) ..
          controls (1103.2767,343.3573) and (1103.2005,293.8351) .. (1101.9060,289.1747)
          .. controls (1100.4881,284.0690) and (1095.5770,278.6928) ..
          (1091.1247,277.3934) .. controls (1089.5526,276.9346) and (1084.7839,276.6274)
          .. (1078.9997,276.5809) -- cycle(1072.9687,286.8502) -- (1078.5129,286.8944)
          .. controls (1090.5687,286.5671) and (1089.0696,297.1226) ..
          (1088.7812,326.7372) .. controls (1088.7812,342.0163) and (1090.3264,351.9036)
          .. (1078.2187,351.9992) -- (1072.7478,351.9992) -- (1072.9687,319.4247) --
          cycle;
          \path[fill=c999999] (1123.0000,362.3622) -- (1122.9620,325.3949) --
          (1123.0000,287.3622) -- (1108.0000,287.3622) -- (1108.0000,276.3622) --
          (1153.0000,276.3622) -- (1153.0000,287.3622) -- (1138.0000,287.3622) --
          (1137.9620,324.9391) -- (1138.0000,362.3622) -- cycle;
          \path[fill=c991a14] (1048.0000,450.3692) .. controls (1048.0000,450.3692) and
          (1071.0924,438.0684) .. (1084.0000,431.3617) .. controls (1120.0000,447.3617)
          and (1140.0000,447.3692) .. (1176.0000,431.3697) -- (1212.0000,450.3697) --
          (1176.0000,469.3622) .. controls (1140.0000,453.3622) and (1120.0000,453.3697)
          .. (1084.0540,469.3622) -- cycle;
          \path[fill=c991a14] (1048.0000,495.3697) .. controls (1048.0000,495.3697) and
          (1071.0924,483.0689) .. (1084.0000,476.3622) .. controls (1120.0000,492.3622)
          and (1140.0000,492.3697) .. (1176.0000,476.3702) -- (1212.0000,495.3702) --
          (1176.0000,514.3627) .. controls (1140.0000,498.3627) and (1120.0000,498.3702)
          .. (1084.0540,514.3627) -- cycle;
        \end{scope}

      \end{tikzpicture}\\
      \vspace{1.5cm}
      {\LARGE Danmarks Tekniske Universitet}
      \vspace{3cm}
      \hrule
      \vspace{0.8cm}
      \textsc{\LARGE \@title}
      \vspace{0.8cm}
      \hrule
      \vspace{0.6cm}
      \textsc{Course:}\\
      \course\\
      \vspace{0.6cm}
      \vspace{2cm}
    \end{center}

    \begin{minipage}[t]{0.6\textwidth}
      \begin{flushleft} \large
        \textsc{Author(s):}\\
        \vspace{0.15cm}
        \@author 
      \end{flushleft}
    \end{minipage}
    \begin{minipage}[t]{0.5\textwidth}
      \begin{flushright} \large
      \end{flushright}
    \end{minipage}
    \vfill
    
    \begin{minipage}[t]{0.8\textwidth}
    \begin{flushleft}
    \includegraphics[width = 0.5\textwidth]{Fig/tex_dtu_compute_a.pdf}~\\
     \course \\
     Carsten Witt
     \end{flushleft}
     \end{minipage}
     
     
    \begin{center}
      \@date
    \end{center}
    \pagestyle{empty}
    \setcounter{page}{0}
  \end{titlepage}
}
\makeatother

\usetikzlibrary{%
  calc,%
  decorations.pathmorphing,%
  fadings,%
  shadings%
}
